**Android Modular by Feature Clean Artitucture**

in this app we im use
**Modular by feature, Mvi , Clean Architucture, Compose , Convention Plugin , Navigation Graph , Room , Kotlin Ksp**

The overall architecture in the photo below

<img src="https://s6.uupload.ir/files/sample_tg5j.jpg" >

Each feature module has its own data, domain, presentation modules,in this way, each module will be completely independent 
If you look at a nowInAndroid repository, you will notice that the **data** and **domain** modules are included in the core module, but here each module has its own data and domain.

in this part we have 2 feature Home and Note,
in Feature Home have a api call with retrofit , in Feature Note have database work call with Room .


