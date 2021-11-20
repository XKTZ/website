<template>
  <div class="home-content" v-html="content">

  </div>
</template>

<script>
import {ref} from "vue";
import {convert} from "@/converter";

export default {
  name: "Home",
  components: {},
  setup() {
    const content = ref("");

    const contentMarkdown = `
# About me

Hello! I am Yidi Chen. I am now a Grade 12 student in St. Augustine Catholic High School.

I am a fan on Computer Science and Mathematics :P

You can see my blogs about competitive programming in the "blog" section.

In the "project" section there would be link to some of my projects.
`;

    content.value = convert(
        contentMarkdown, "markdown"
    )

    return {content};
  }
}
</script>

<style scoped>
.home-content {
  font-size: 120%;
  text-align: left;
}
</style>