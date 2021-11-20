<template>
  <div ref="blogContainer">
    <el-space direction="vertical" wrap>
        <blog-item v-for="blog in blogs"
                   :key="blog"
                   :id="blog.id"
                   :title="blog.title"
                   :author="blog.author"
                   :summary="blog.summary"
                   :created-date="blog.createdDate"
                   :type="blog.type"
                   :blog-container="blogContainerElement">
        </blog-item>
    </el-space>
  </div>
</template>

<script>
import BlogItem from "@/components/blog/BlogItem";
import {reactive, ref} from "vue";
import axios from 'axios';

export default {
  name: "Blog",
  components: {BlogItem},
  setup() {
    const blogContainer = ref(null);
    const blogs = ref([]);
    axios.get("/blog/").then((res) => {
      res.data.forEach((blog) => {
        blogs.value.push(blog)
      })
    })
    return {
      blogs,
      blogContainer,
      blogContainerElement: reactive({
        value: blogContainer
      })
    }
  }
}
</script>

<style scoped>

</style>