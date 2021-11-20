<template>
  <!--project-->
  <el-space direction="horizontal" wrap>
    <project-item :key="project" v-for="project in projects"
                  :url="project.url"
                  :name="project.name"
                  :desc="project.desc"></project-item>
  </el-space>
</template>

<script>

import {ref} from "vue";
import axios from "axios";
import ProjectItem from "@/components/project/ProjectItem";

export default {
  name: "Project",
  components: {ProjectItem},
  setup() {
    const projects = ref([]);
    axios.get("/project/").then(res => {
      res.data.forEach((project) => {
        projects.value.push(project)
      })
    })
    return {projects}
  }
}
</script>

<style scoped>

</style>