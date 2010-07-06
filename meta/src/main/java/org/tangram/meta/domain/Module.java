/*
 * Copyright (C) <2010>  <Li Guoqiang>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.tangram.meta.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: Module</p>
 * <p>Description: Module prsents a module of application.</p>
 * <p>Organization: OssJet.org </p>
 * <p>Created: 2010-7-5 </p>
 *
 * @author Li Guoqiang<mail.lgq@gmail.com>
 * @version 1.0
 */
public class Module {
    private final Logger logger = LoggerFactory.getLogger(Module.class);
    private ReentrantLock lock = new ReentrantLock();

    private CopyOnWriteArrayList<String> usedModuleList;
    private Navigation navigation;
    private ConcurrentMap<String, ModelClass> classMap;
    private ConcurrentMap<String, Window> windowMap;
    private ConcurrentMap<String, Process> processMap;

    private String name;

    public Module(String name, String[] usedModules, Navigation navigation, ModelClass[] classes,
                  Window[] windows, Process[] processes) {
        this.name = name;
        this.usedModuleList = new CopyOnWriteArrayList<String>(usedModules);
        this.navigation = navigation;

        this.classMap = new ConcurrentHashMap<String, ModelClass>();
        this.windowMap = new ConcurrentHashMap<String, Window>();
        this.processMap = new ConcurrentHashMap<String, Process>();

        addModelClasses(classes);
        addWindows(windows);
        addProcesses(processes);
    }

    /**
     * Add processes into module, existed will be overridden.
     *
     * @param processes Array of Process
     */
    public void addProcesses(Process... processes) {
        if (processes.length == 1) {
            Process process = processes[0];
            processMap.put(process.getName(), process);
        } else {
            lock.lock();
            try {
                for (Process process : processes) {
                    processMap.put(process.getName(), process);
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * Get all defined processes in module.
     *
     * @return Array of Process
     */
    public Process[] getProcesses() {
        return processMap.values().toArray(new Process[processMap.size()]);
    }

    /**
     * Add windows definition into Module, existed will be overridden.
     *
     * @param windows Array of Window
     */
    public void addWindows(Window... windows) {
        if (windows.length == 1) {
            Window window = windows[0];
            windowMap.put(window.getName(), window);
        } else {
            lock.lock();
            try {
                for (Window window : windows) {
                    windowMap.put(window.getName(), window);
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * Get all windows definition of module.
     *
     * @return Array of Window
     */
    public Window[] getWindows() {
        return windowMap.values().toArray(new Window[windowMap.size()]);
    }

    /**
     * Add model classes definition into module, existed will be overridden.
     *
     * @param classes Array of ModelClass
     */
    public void addModelClasses(ModelClass... classes) {
        if (classes.length == 1) {
            ModelClass clazz = classes[0];
            classMap.put(clazz.getName(), clazz);
        } else {
            lock.lock();
            try {
                for (ModelClass clazz : classes) {
                    classMap.put(clazz.getName(), clazz);
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * Get all ModelClasses of module.
     * @return Array of ModelClass
     */
    public ModelClass[] getModelClasses() {
        return classMap.values().toArray(new ModelClass[classMap.size()]);
    }

    /**
     * Get used module array
     *
     * @return Array of module name
     */
    public String[] getUsedModules() {
        return usedModuleList.toArray(new String[usedModuleList.size()]);
    }

    /**
     * Add used modules
     *
     * @param moduleNames Array
     */
    public void addUsedModules(String... moduleNames) {
        if (moduleNames.length == 1) {
            usedModuleList.add(moduleNames[0]);
        } else {
            usedModuleList.addAll(Arrays.asList(moduleNames));
        }
    }

    public String getName() {
        return name;
    }

    public Navigation getNavigation() {
        return navigation;
    }
}
