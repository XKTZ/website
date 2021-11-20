<template>
  <div class="blog-content" v-html="content">
  </div>
</template>

<script>
import {useRoute} from "vue-router";
import {ref} from "vue";
import {convert} from "@/converter";
import axios from "axios";
import 'highlight.js/styles/vs2015.css'
import 'katex/dist/katex.min.css';

export default {
  name: "BlogContent",
  setup() {
    const router = useRoute();
    const id = ref(router.params.id);
    const content = ref("");
    axios({
      method: "get",
      url: `/blog/${id.value}`,
      data: {}
    }).then(res => {
      content.value = convert(res.data.content, res.data.header.type)
    })
    return {id, content};
  }
}
</script>

<style scoped>
.blog-content {
  text-align: left;
}
</style>