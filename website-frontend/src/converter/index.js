const highlighter = require('highlight.js')

const markdownRender = require('markdown-it')({
    highlight(str, lang) {
        if (lang && highlighter.getLanguage(lang)) {
            try {
                return '<pre class="hljs" style="padding: .5%;"><code>' +
                    highlighter.highlight(str, {language: lang, ignoreIllegals: true}).value +
                    '</code></pre>';
            } catch (__) {
                console.log(__)
            }
        }
        return '<pre class="hljs" style="padding: .5%;"><code>' +
            markdownRender.utils.escapeHtml(str) + '</code></pre>';
    }
})

const texPlugin = require('markdown-it-mathtex')
markdownRender.use(texPlugin, {
    engine: require('katex'),
    delimiters: 'dollars'
})

const convertMap = {
    "html": (data) => data,
    "markdown": (data) => markdownRender.render(data),
    "md": (data) => markdownRender.render(data)
}

export function convert(data, type) {
    if (convertMap[type] === undefined) {
        return data;
    }
    return convertMap[type](data);
}