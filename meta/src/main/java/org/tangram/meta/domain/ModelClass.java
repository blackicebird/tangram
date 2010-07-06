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

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class ModelClass {
    private String name;
    private String parent;
    private String javadoc;
    private CopyOnWriteArrayList<Property> properties;
    private CopyOnWriteArrayList<Listener> entityListeners;

    public ModelClass(String name, String parent, String javadoc, Property[] properties, Listener[] listeners) {
        this.name = name;
        this.parent = parent;
        this.javadoc = javadoc;

        this.properties = new CopyOnWriteArrayList<Property>(properties);
        this.entityListeners = new CopyOnWriteArrayList<Listener>(listeners);
    }

    /**
     * Add Properties.
     *
     * @param properties Properties
     */
    public void addProperties(Property... properties) {
        if (properties.length == 1) {
            this.properties.add(properties[0]);
        } else {
            this.properties.addAll(Arrays.asList(properties));
        }
    }

    /**
     * Get properties.
     *
     * @return Array of Property
     */
    public Property[] getProperties() {
        return this.properties.toArray(new Property[this.properties.size()]);
    }

    /**
     * Add Entity listeners.
     *
     * @param listeners Listeners
     */
    public void addEntityListeners(Listener... listeners) {
        if (listeners.length == 1) {
            this.entityListeners.add(listeners[0]);
        } else {
            this.entityListeners.addAll(Arrays.asList(listeners));
        }
    }

    /**
     * Get Entity listeners.
     *
     * @return Array of Listener
     */
    public Listener[] getEntityListeners() {
        return this.entityListeners.toArray(new Listener[this.entityListeners.size()]);
    }

    public String getName() {
        return name;
    }

    public String getParent() {
        return parent;
    }

    public String getJavadoc() {
        return javadoc;
    }

}
