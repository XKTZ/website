<template>
  <div>
    <router-link to="/console/">
      <el-button style="width: 100%;">Go Back</el-button>
    </router-link>
    <el-table :data="projects" style="width: 100%;"
              :default-sort="{ prop: 'id', order: 'descending' }">
      <el-table-column prop="name" label="Title" width="200%"/>
      <el-table-column prop="desc" label="Description" width="150%"/>
      <el-table-column prop="url" label="URL" width="150%"/>
      <el-table-column label="Operations" width="350%">
        <template #default="scope">
          <el-button type="danger" @click="remove(scope.row.id)" style="width: 45%">
            Delete
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>

import {ref} from "vue";
import axios from "axios";

export default {
  name: "ProjectRemovePanel",
  setup() {
    const projects = ref([]);

    const refresh = async function () {
      projects.value = [];
      let data = (await axios.get("/project/")).data;
      data.forEach(prj => projects.value.push(prj))
    };

    const remove = async function(id) {
      let ret = (await axios.delete(`/console/project/${id}`)).data
      await refresh();
      alert(ret.message)
    };

    refresh();

    return {projects, remove};
  }
}
</script>

<style scoped>

</style>