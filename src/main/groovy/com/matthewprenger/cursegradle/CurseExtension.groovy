package com.matthewprenger.cursegradle

class CurseExtension {

    /**
     * Optional global apiKey. Will be applied to all projects that don't declare one
     */
    def apiKey = '' // Initialize to empty string to delay error until the task is actually ran

    final Collection<CurseProject> curseProjects = new ArrayList<>()

    boolean debug = false

    /**
     * Define a new CurseForge project for deployment
     *
     * @param configClosure The configuration closure
     */
    CurseProject project(Closure<?> configClosure) {
        CurseProject curseProject = new CurseProject()
        curseProject.with(configClosure)
        if (curseProject.apiKey == null) {
            curseProject.apiKey = this.apiKey
        }
        curseProjects.add(curseProject)
        return curseProject
    }
}
