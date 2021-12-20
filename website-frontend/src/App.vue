<template>
  <div ref="appContainer">
    <el-header :style="`height: ${headerHeight}; margin: 0; padding: 0;`">
      <header-menu></header-menu>
    </el-header>
    <el-scrollbar :height="mainHeight" class="main">
      <el-main>
        <router-view/>
      </el-main>
    </el-scrollbar>
  </div>
</template>

<script>

import {ElMain} from "element-plus";
import {ref} from "vue";
import HeaderMenu from "@/views/HeaderMenu";

export default {
  name: 'App',
  components: {
    HeaderMenu,
    ElMain,
  },
  setup() {

    const main = ref(null);
    const headerHeight = ref(`${window.innerHeight * .1}px`)
    const mainHeight = ref(`${window.innerHeight * .9}px`);

    return {main, headerHeight, mainHeight}
  }
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body {
  overflow-y: hidden;
  padding: 0;
  margin: 0;
}

.main {
  background-color: #f4f4f4;
}

</style>