<template>
  <div>
    <router-link to="/console/">
      <el-button style="width: 100%;">Go Back</el-button>
    </router-link>
    <el-table :data="blogs" style="width: 100%;"
              :default-sort="{ prop: 'id', order: 'descending' }">
      <el-table-column prop="title" label="Title" width="250%"/>
      <el-table-column prop="author" label="Author" width="250%"/>
      <el-table-column label="Operations" width="350%">
        <template #default="scope">
          <el-button @click="view(scope.row.id)" style="width: 45%">
            View
          </el-button>
          <el-button type="danger" @click="remove(scope.row.id)" style="width: 45%">
            Delete
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
  <!-- View of Blogs -->
  <el-drawer v-model="openView" :with-header="false" size="70%" :append-to-body="true">
    <el-scrollbar :max-height="viewHeight">
      <div class="preview" v-html="blogContentHtml"></div>
    </el-scrollbar>
  </el-drawer>
</template>

<script>

import {ref} from "vue";
import axios from "axios";
import {convert} from "@/converter";

export default {
  name: "BlogRemovePanel",
  setup() {
    const blogs = ref([]);
    const openView = ref(false);
    const blogContentHtml = ref("");

    const viewHeight = ref(`${screen.height * .8}px`);

    const refresh = async function() {
      blogs.value = []
      axios.get("/blog/").then(res => {
        res.data.forEach((blg) => {
          blogs.value.push(blg)
        })
      });
    }

    const view = async function (id) {
      let ret = (await axios.get(`/blog/${id}`)).data;
      blogContentHtml.value = convert(ret.content, ret.header.type);
      openView.value = true;
    }

    const remove = async function(id) {
      let ret = (await axios.delete(`/console/blog/${id}`)).data;
      await refresh();
      alert(ret.message);
    }

    refresh();

    return {blogs, openView, blogContentHtml, viewHeight, view, remove, refresh};
  }
}
</script>

<style scoped>

</style>