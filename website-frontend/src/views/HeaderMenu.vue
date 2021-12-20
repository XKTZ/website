<template>
  <div class="header-menu">
    <el-menu router mode="horizontal">
      <el-menu-item @click="openGithub">
        <a :href="githubLink" target="_blank" style="text-decoration: none; padding: 0; margin: 0;">
        <span class="header-menu-name-text">
          Yidi Chen
        </span>
        </a>
      </el-menu-item>
      <el-menu-item index="/">
        <span>
          Home
        </span>
      </el-menu-item>
      <el-menu-item index="/blog">
        <span>
          Blog
        </span>
      </el-menu-item>
      <el-menu-item index="/project">
        <span>
          Project
        </span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import {ref} from "vue";

export default {
  name: "header-menu",
  components: {},
  setup() {
    const githubLink = ref("https://github.com/XKTZ");
    return {githubLink};
  }
}
</script>

<style scoped>
.header-menu-name-text {
  font-family: "Times New Roman", serif;
  font-size: 200%;
  font-weight: 800;
}
</style>