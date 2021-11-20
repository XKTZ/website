import { createRouter, createWebHashHistory } from 'vue-router'
import Home from "@/views/Home";
import Blog from "@/views/blog/Blog";
import BlogContent from "@/views/blog/BlogContent";
import Project from "@/views/project/Project";
import Console from "@/views/console/Console";
import Login from "@/views/console/Login";
import BlogAddPanel from "@/views/console/edit/BlogAddPanel";
import BlogRemovePanel from "@/views/console/edit/BlogRemovePanel";
import ProjectAddPanel from "@/views/console/edit/ProjectAddPanel";
import ProjectRemovePanel from "@/views/console/edit/ProjectRemovePanel";

const routes = [
  /*
  {
  path: ,
  name: ,
  component: ,
  }
   */
  {
    path: "/",
    name: "home",
    component: Home
  },
  {
    path: "/blog",
    name: "blog",
    component: Blog
  },
  {
    path: "/blog/:id",
    name: "blogContent",
    component: BlogContent
  },
  {
    path: "/project",
    name: "project",
    component: Project
  },
  {
    path: "/console",
    name: "console",
    component: Console
  },
  {
    path: "/console/blog-add",
    name: "console.blogAdd",
    component: BlogAddPanel
  },
  {
    path: "/console/blog-remove",
    name: "console.blogRemove",
    component: BlogRemovePanel
  },
  {
    path: "/console/project-add",
    name: "console.projectAdd",
    component: ProjectAddPanel
  },
  {
    path: "/console/project-remove",
    name: "console.projectRemove",
    component: ProjectRemovePanel
  },
  {
    path: "/login",
    name: "login",
    component: Login
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
