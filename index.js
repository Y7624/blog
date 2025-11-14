import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/home.vue'
import Article from '../views/article.vue'
import ArticleDetail from '../views/articleDetail.vue'
import Project from '../views/project.vue'
import About from '../views/about.vue'


const routes = [
    {
        path: '/',
        name: 'home',
        component: Home
    },
    {
        path: '/article',
        name: 'article',
        component: Article
    },
    {
        path: '/article/:id',
        name: 'articleDetail',
        component: ArticleDetail,
        props: true
    },
    {
        path: '/project',
        name: 'project',
        component: Project
    },
    {
        path: '/about',
        name: 'about',
        component: About
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router