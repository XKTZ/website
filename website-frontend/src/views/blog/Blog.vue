<template>
  <div class="blog" ref="blogContainer">
    <loader v-if="loading"/>
    <el-space v-if="!loading" direction="vertical" wrap>
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
import Loader from "@/components/loader/Loader";

export default {
  name: "Blog",
  components: {Loader, BlogItem},
  setup() {
    const blogContainer = ref(null);
    const blogs = ref([]);
    const loading = ref(true);

    axios.get("/blog/").then((res) => {
      res.data.sort((a, b) => b.id - a.id);
      res.data.forEach(x => {
        x.createdDate = new Date(x.createdDate)
        blogs.value.push(x)
      })
      loading.value = false;
    })
    return {
      blogs,
      blogContainer,
      loading,
      blogContainerElement: reactive({
        value: blogContainer
      })
    }
  }
}
</script>

<style scoped>
.blog {
  padding-top: 10px;
}
</style>