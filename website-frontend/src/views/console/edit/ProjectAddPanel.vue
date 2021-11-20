<template>
  <div>
    <router-link to="/console/">
      <el-button style="width: 100%;">Go Back</el-button>
    </router-link>
    <el-input class="data-input" v-model="projectName" placeholder="Project Title"/>
    <el-input class="data-input" v-model="projectSummary" placeholder="Project Summary"/>
    <el-input class="data-input" v-model="projectUrl" placeholder="Project Url"/>
    <div class="action-component">
      <el-button @click="submit()">Submit</el-button>
    </div>
  </div>
</template>

<script>
import {ref} from "vue";
import axios from "axios";
import qs from "qs";

export default {
  name: "ProjectAddPanel",
  setup() {
    const projectName = ref("");
    const projectUrl = ref("");
    const projectSummary = ref("");

    const submit =ref(async function () {
      let data = qs.stringify({
        name: projectName.value,
        desc: projectSummary.value,
        url: projectUrl.value
      });
      let ret = (await axios.post("/console/project/", data)).data;
      alert(ret.message)
    })

    return {projectName, projectUrl, projectSummary, submit}
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