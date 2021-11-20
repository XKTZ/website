<template>
  <div class="side-menu">
    <el-menu router>
      <side-item name="Home" url="/"></side-item>
      <side-item name="Blog" url="/blog"></side-item>
      <side-item name="Project" url="/project"></side-item>
    </el-menu>
  </div>
</template>

<script>
import SideItem from "@/components/main/SideItem";

export default {
  name: "side",
  components: {SideItem}
}
</script>

<style scoped>

</style>