<template>
  <el-main>
    <div>
      <router-link to="/console/blog-add">
        <el-button class="section-button">Blog Add</el-button>
      </router-link>
    </div>
    <div>
      <router-link to="/console/blog-remove">
        <el-button class="section-button">Blog Remove</el-button>
      </router-link>
    </div>
    <div>
      <router-link to="/console/project-add">
        <el-button class="section-button">Project Add</el-button>
      </router-link>
    </div>
    <div>
      <router-link to="/console/project-remove">
        <el-button class="section-button">Project Remove</el-button>
      </router-link>
    </div>
  </el-main>
</template>

<script>

// import {ref} from "vue";

export default {
  name: "ControlPanel",
  components: {},
  setup() {
    return {}

  }
}
</script>

<style scoped>
.section-button {
  width: 100%;
  margin-top: 2%;
  margin-bottom: 2%;
}
</style>