package chao.android.gradle.plugin.dependencies

import chao.android.gradle.plugin.Constant

/**
 * @author qinchao
 *
 * @since 2019/7/1 
 */
class ModuleBuilder {

    private String name

    private String remote

    private String project

    /**
     *  todo
     */
    private String buildScope

    /**
     *  todo
     */
    private String flavorScope

    private boolean useProject

    private ModuleHandler handler

    ModuleBuilder(ModuleHandler handler) {
        this.handler = handler
    }

    ModuleBuilder name(String name) {
        this.name = name
        this.useProject = false;
        return this
    }

    ModuleBuilder remote(String remote) {
        this.remote = remote
        return this
    }

    ModuleBuilder project(String project) {
        this.project = project
        return this
    }

    /**
     * 将这个project载入到项目
     * @return
     */
    ModuleBuilder include() {
        handler.project(name, project)
        useProject = true
        return this
    }

    ModuleBuilder onlyDebug() {
        this.buildScope = Constant.buildType.DEBUG
        return this
    }

    ModuleBuilder onlyRelease() {
        this.buildScope = Constant.buildType.RELEASE
    }

    ModuleBuilder builderScope(String scope) {
        this.buildScope = scope
        return this
    }

    ModuleBuilder flavorScope(String scope) {
        this.flavorScope = scope
        return this
    }

    String getName() {
        return name
    }

    Module build() {
        Module module = new Module()
        module.name = name
        module.remote = remote
        module.useProject = useProject
        module.project = project
        module.flavorScope = flavorScope
        module.buildScope = buildScope
        return module
    }
}