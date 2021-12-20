<template>
  <div class="project" ref="projectContainer">
    <!--project-->
    <el-space direction="vertical">
      <project-item :key="project" v-for="project in projects"
                    :url="project.url"
                    :name="project.name"
                    :desc="project.desc"
                    :project-container="projectContainerElement"></project-item>
    </el-space>
  </div>
</template>

<script>

import {reactive, ref} from "vue";
import axios from "axios";
import ProjectItem from "@/components/project/ProjectItem";

export default {
  name: "Project",
  components: {ProjectItem},
  setup() {
    const projects = ref([]);
    const projectContainer = ref(null);
    axios.get("/project/").then(res => {
      res.data.forEach((project) => {
        projects.value.push(project)
      })
    })
    return {
      projects, projectContainer,
      projectContainerElement: reactive({
        value: projectContainer
      })
    }
  }
}
</script>

<style scoped>
.project {
  padding-top: 10px;
}
</style>