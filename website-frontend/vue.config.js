const fs = require("fs")

let settings = JSON.parse(fs.readFileSync("settings.json", "utf-8"))

module.exports = {
    devServer: {
        proxy: {
            "/": {
                target: settings.devServer,
                changeOrigin: true
            }
        }
    }
}