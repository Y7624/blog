import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'
import Particles from "@tsparticles/vue3";
import { loadSlim } from "@tsparticles/slim";
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

const app = createApp(App)

app.use(ElementPlus)
app.use(Particles, {
    init: async (engine) => {
        await loadSlim(engine);
    }
})

app.use(router).use(createPinia())


app.mount('#app')
