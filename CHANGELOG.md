# Changelog

## 0.1.0-alpha.3 (2025-09-20)

Full Changelog: [v0.1.0-alpha.2...v0.1.0-alpha.3](https://github.com/hudhud-sdks/sdk-kotlin/compare/v0.1.0-alpha.2...v0.1.0-alpha.3)

### Features

* add retryable exception ([a2aa5bf](https://github.com/hudhud-sdks/sdk-kotlin/commit/a2aa5bff889606a2851187c86d198a34183ee252))
* **client:** ensure compat with proguard ([d6354f6](https://github.com/hudhud-sdks/sdk-kotlin/commit/d6354f697f82370ae6bc9cf4fded64cf20f699f8))
* **client:** expose sleeper option ([2897cad](https://github.com/hudhud-sdks/sdk-kotlin/commit/2897cada578d49eed5e4c2fc4261c2d30b791dd6))


### Bug Fixes

* **ci:** use java-version 21 for publish step ([c606ce4](https://github.com/hudhud-sdks/sdk-kotlin/commit/c606ce490e793a82a2fa069037b0f40f9c26b834))
* **client:** ensure single timer is created per client ([2897cad](https://github.com/hudhud-sdks/sdk-kotlin/commit/2897cada578d49eed5e4c2fc4261c2d30b791dd6))
* **client:** r8 support ([c9ead90](https://github.com/hudhud-sdks/sdk-kotlin/commit/c9ead90efad91c975b2816b77d0085b7199a6d65))


### Performance Improvements

* **internal:** make formatting faster ([7d6205c](https://github.com/hudhud-sdks/sdk-kotlin/commit/7d6205c7aeeeb3bc234101a04843085444408485))


### Chores

* **ci:** add build job ([1f8f8a9](https://github.com/hudhud-sdks/sdk-kotlin/commit/1f8f8a97f9c919ac5f59931b825657a78f2e1733))
* **ci:** reduce log noise ([3d62fe3](https://github.com/hudhud-sdks/sdk-kotlin/commit/3d62fe372c018c8001b80133a6e6082766130ed2))
* **client:** refactor closing / shutdown ([6ca80cb](https://github.com/hudhud-sdks/sdk-kotlin/commit/6ca80cb6f92fb697e03a7a5889023bc524e30ff4))
* **example:** fix run example comment ([f150ae0](https://github.com/hudhud-sdks/sdk-kotlin/commit/f150ae07a1c6fc78b0e0edf789a23f498c6022c7))
* increase max gradle JVM heap to 8GB ([e262a38](https://github.com/hudhud-sdks/sdk-kotlin/commit/e262a388e1d259477b7669126b7dcc6d72aeff60))
* **internal:** add lock helper ([1eaf7de](https://github.com/hudhud-sdks/sdk-kotlin/commit/1eaf7dea99d80ac5753ceaf2c2a6cb73a9f94f46))
* **internal:** bump ci test timeout ([3a82afd](https://github.com/hudhud-sdks/sdk-kotlin/commit/3a82afdf146968f158f06854038f6c9704026fcf))
* **internal:** codegen related update ([0595d40](https://github.com/hudhud-sdks/sdk-kotlin/commit/0595d4014aa986c592f78a71684e26a0afd21f51))
* **internal:** codegen related update ([2ca6f4e](https://github.com/hudhud-sdks/sdk-kotlin/commit/2ca6f4e08b12b20f8ff752883808deb40d91d52f))
* **internal:** codegen related update ([1402b5e](https://github.com/hudhud-sdks/sdk-kotlin/commit/1402b5e7f0559f3e379fa9a671398547db197443))
* **internal:** dynamically determine included projects ([62d63fa](https://github.com/hudhud-sdks/sdk-kotlin/commit/62d63fa252dbcc76975a34b855925b279880e202))
* **internal:** reduce proguard ci logging ([53ce1bf](https://github.com/hudhud-sdks/sdk-kotlin/commit/53ce1bfb397596e85f90d08f8b9368765625605a))
* **internal:** remove unnecessary `[...]` in `[@see](https://github.com/see)` ([e518aa0](https://github.com/hudhud-sdks/sdk-kotlin/commit/e518aa057dee7e9cedc99290a8eab29f3dcb1825))
* **internal:** support passing arguments to test script ([4dfed5b](https://github.com/hudhud-sdks/sdk-kotlin/commit/4dfed5b05d22a320a322a62264724f0a6c70a905))
* **internal:** support running ktfmt directly ([28ea1c8](https://github.com/hudhud-sdks/sdk-kotlin/commit/28ea1c852cd30d793d92a593c9a44ad88567be68))
* **internal:** unskip some tests ([fc835cf](https://github.com/hudhud-sdks/sdk-kotlin/commit/fc835cfd8e13f687ef246a98f8e13bb82bc5deda))
* **internal:** update comment in script ([f600aa8](https://github.com/hudhud-sdks/sdk-kotlin/commit/f600aa8efb5180f6435dcd9cd67e55a1e2e615fd))
* remove memory upper bound from publishing step ([5cf76ea](https://github.com/hudhud-sdks/sdk-kotlin/commit/5cf76eac3dd7827b4588cd80111fa1ddcf0e7567))
* update @stainless-api/prism-cli to v5.15.0 ([a42c4be](https://github.com/hudhud-sdks/sdk-kotlin/commit/a42c4be84f96666b63bcc880171074f799c5eedf))


### Documentation

* fix missing readme comment ([3104b2a](https://github.com/hudhud-sdks/sdk-kotlin/commit/3104b2a4affa844895c1eed11cab929f7c6ea928))
* more code comments ([611babf](https://github.com/hudhud-sdks/sdk-kotlin/commit/611babf643907f66f9ebc1493c926001fa02aa34))

## 0.1.0-alpha.2 (2025-07-22)

Full Changelog: [v0.1.0-alpha.1...v0.1.0-alpha.2](https://github.com/hudhud-sdks/sdk-kotlin/compare/v0.1.0-alpha.1...v0.1.0-alpha.2)

### Features

* **api:** update via SDK Studio ([6089bc1](https://github.com/hudhud-sdks/sdk-kotlin/commit/6089bc1b028915332ee5d438bf5a8aaee05dd38f))

## 0.1.0-alpha.1 (2025-07-22)

Full Changelog: [v0.0.1-alpha.0...v0.1.0-alpha.1](https://github.com/hudhud-sdks/sdk-kotlin/compare/v0.0.1-alpha.0...v0.1.0-alpha.1)

### Features

* **api:** update via SDK Studio ([186c71f](https://github.com/hudhud-sdks/sdk-kotlin/commit/186c71fb005edb7b422dd34f312d0d192e2704cb))
* **api:** update via SDK Studio ([585926b](https://github.com/hudhud-sdks/sdk-kotlin/commit/585926b188bd1a92f3d5796ae213293b21d63972))
* **client:** add `{QueryParams,Headers}#put(String, JsonValue)` methods ([c9a3cfb](https://github.com/hudhud-sdks/sdk-kotlin/commit/c9a3cfb0294f4d6922faa5762801b7e160cf976b))
* **client:** add https config options ([45d81e4](https://github.com/hudhud-sdks/sdk-kotlin/commit/45d81e4437bc241fa2726421afdd3ed7a1413392))
* **client:** allow configuring env via system properties ([c1062f6](https://github.com/hudhud-sdks/sdk-kotlin/commit/c1062f663731dbaa589ea658fb7a9ff5c8e85325))


### Bug Fixes

* **client:** ensure error handling always occurs ([d0eaffb](https://github.com/hudhud-sdks/sdk-kotlin/commit/d0eaffb20554e4b543e2c2b23ecb50949736e0fc))
* **internal:** set maven publish url ([af31321](https://github.com/hudhud-sdks/sdk-kotlin/commit/af31321f69eb31fa8d756cf0fd6c55ce324dddc1))


### Chores

* **ci:** bump `actions/setup-java` to v4 ([263a3ae](https://github.com/hudhud-sdks/sdk-kotlin/commit/263a3ae93f67b3ba984c422e0ab8f252392a9756))
* **internal:** allow running specific example from cli ([0d49aeb](https://github.com/hudhud-sdks/sdk-kotlin/commit/0d49aebb7bd90993eb6babcb3ce008b82fdf3900))
* **internal:** refactor delegating from client to options ([e7082c2](https://github.com/hudhud-sdks/sdk-kotlin/commit/e7082c2f747c14500a67c7b9340e3d3717d418e4))
* update SDK settings ([423fee1](https://github.com/hudhud-sdks/sdk-kotlin/commit/423fee1060ec06979d9a44d8b41025326b95f2c3))
