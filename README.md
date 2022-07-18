[![Hosted By: Cloudsmith](https://img.shields.io/badge/OSS%20hosting%20by-cloudsmith-blue?logo=cloudsmith&style=for-the-badge)](https://cloudsmith.com)

# Cactus Config

## About

Cactus Config is a library mod for Minecraft.

## For Users

If a mod requires Cactus Config but does not include it, you can download it from GitHub releases.

## For Developers

To use Cactus Config in a mod project, use the repository and modImplementation as provided below.

#### Repository
```groovy
repositories {
    maven {
        name = 'Cactus Config'
        url = 'https://dl.cloudsmith.io/public/carbon-toast/cactus-config/maven/'
    }
}
```

#### Dependency
Make sure that you replace _VERSION_ with the most recent version.
```groovy
dependencies {
    include modImplementation('io.github.thepoultryman:cactus-config:VERSION')
}
```
[![Latest version of 'cactus-config' @ Cloudsmith](https://api-prd.cloudsmith.io/v1/badges/version/carbon-toast/cactus-config/maven/cactus-config/latest/a=noarch;xg=io.github.thepoultryman/?render=true&show_latest=true)](https://cloudsmith.io/~carbon-toast/repos/cactus-config/packages/detail/maven/cactus-config/latest/a=noarch;xg=io.github.thepoultryman/)

_Package repository hosting is graciously provided by  [Cloudsmith](https://cloudsmith.com).
Cloudsmith is the only fully hosted, cloud-native, universal package management solution, that
enables your organization to create, store and share packages in any format, to any place, with total
confidence._
