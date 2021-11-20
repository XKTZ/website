<template>
  <div>
    <router-link to="/console/">
      <el-button style="width: 100%;">Go Back</el-button>
    </router-link>
    <el-input class="data-input" v-model="blogName" placeholder="Blog Title"/>
    <el-input class="data-input" v-model="blogAuthor" placeholder="Blog Author"/>
    <el-input class="data-input" v-model="blogSummary" placeholder="Blog Summary"/>
    <el-select class="data-input" v-model="blogType" placeholder="Select Type">
      <el-option key="html" value="html" label="HTML"></el-option>
      <el-option key="markdown" value="markdown" label="Markdown"></el-option>
    </el-select>
    <el-input class="data-input" type="textarea"
              :autosize="{minRows: 15}"
              v-model="blogContent"/>
    <div class="action-component">
      <el-button @click="preview()">Preview</el-button>
      <el-button @click="submit()">Submit</el-button>
    </div>
    <!-- preview -->
    <el-drawer v-model="openPreview" :with-header="false" size="70%">
      <el-scrollbar :max-height="previewHeight">
        <div class="preview" v-html="blogContentHtml"></div>
      </el-scrollbar>
    </el-drawer>
  </div>
</template>

<script>
import {ref} from "vue";
import qs from 'qs';
import axios from "axios";
import {convert} from "@/converter";
import 'highlight.js/styles/vs2015.css'
import 'katex/dist/katex.min.css';

export default {
  name: "BlogAddPane",
  setup() {
    const blogName = ref("");
    const blogAuthor = ref("");
    const blogSummary = ref("");
    const blogType = ref("html");
    const blogContent = ref("");
    const blogContentHtml = ref("");
    const openPreview = ref(false);

    const previewHeight = ref(`${screen.height * .8}px`);

    const submit = ref(async function () {

      const data = qs.stringify({
        title: blogName.value,
        author: blogAuthor.value,
        summary: blogSummary.value,
        type: blogType.value,
        authority: 0,
        content: blogContent.value
      });

      let res = (await axios.post("/console/blog/", data)).data;
      alert(res.message)
    });

    const preview = ref(() => {
      blogContentHtml.value = convert(blogContent.value, blogType.value);
      openPreview.value = true;
    });

    return {
      blogName,
      blogAuthor,
      blogSummary,
      blogType,
      blogContent,
      openPreview,
      blogContentHtml,
      preview,
      previewHeight,
      submit
    };
  }
}
</script>

<style scoped>
.preview {
  text-align: left;
}

.action-component {
  width: 100%;
}


.data-input {
  margin-top: 1%;
  margin-bottom: 1%;
  width: 100%;
}

</style>