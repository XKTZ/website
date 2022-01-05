<template>
  <div :style="loadingStyle" v-loading="true" element-loading-text="Loading..."
       element-loading-background="#f4f4f4">

  </div>
</template>

<script>

import {ref} from "vue";

export default {
  name: "Loader",
  setup() {
    const loadingStyle = ref({
      "height": `${window.innerHeight * .85}px`,
      "border": 0,
    });
    return {
      loadingStyle
    }
  }
}
</script>

<style scoped>
</style>