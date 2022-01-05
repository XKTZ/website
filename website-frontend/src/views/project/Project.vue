<template>
  <div class="project" ref="projectContainer">
    <loader v-if="loading"/>
    <!--project-->
    <el-space v-if="!loading" direction="vertical">
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
import Loader from "@/components/loader/Loader";

export default {
  name: "Project",
  components: {Loader, ProjectItem},
  setup() {
    const projects = ref([]);
    const projectContainer = ref(null);
    const loading = ref(true);
    axios.get("/project/").then(res => {
      res.data.forEach((project) => {
        projects.value.push(project)
      })
      loading.value = false;
    })
    return {
      projects,
      projectContainer,
      loading,
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