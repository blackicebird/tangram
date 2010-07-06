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

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: Application</p>
 * <p>Description: Application presents a real application that implemented many functions by modules.</p>
 * <p>Organization: OssJet.org </p>
 * <p>Created: 下午2:25 2010-7-5</p>
 *
 * @author Li Guoqiang<mail.lgq@gmail.com>
 * @version 1.0
 */
public class Application {
    private final Logger logger = LoggerFactory.getLogger(Application.class);
    private ConcurrentMap<String, Module> moduleMap;
    private ReentrantLock lock = new ReentrantLock();

    /**
     * Construct application by modules
     *
     * @param modules modules
     */
    public Application(Module[] modules) {
        moduleMap = new ConcurrentHashMap<String, Module>();

        addModules(modules);
    }

    /**
     * Add modules, existed will be overridden.
     *
     * @param modules modules
     */
    public void addModules(Module[] modules) {
        lock.lock();
        try {
            for (Module module : modules) {
                moduleMap.put(module.getName(), module);
            }
        } finally {
            lock.unlock();
        }
    }


    /**
     * Add module to application, existed will be overridden
     *
     * @param module module instance
     */
    public void addModule(Module module) {
        moduleMap.put(module.getName(), module);
    }

    /**
     * Get module by name
     *
     * @param name module name
     * @return Module or null
     */
    public Module getModule(String name) {
        return moduleMap.get(name);
    }
}
