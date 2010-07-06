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
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>Title: Property</p>
 * <p>Description: Property </p>
 * <p>Organization: OssJet.org </p>
 * <p>Created: 2010-7-6 </p>
 *
 * @author Li Guoqiang<mail.lgq@gmail.com>
 * @version 1.0
 */
public class Property {
    private String name;
    private String label;
    private String type;
    private Integer length;
    private Boolean required = Boolean.FALSE;
    private Boolean editable = Boolean.FALSE;
    private Boolean notNull = Boolean.FALSE;
    private Boolean array = Boolean.FALSE;
    private Boolean reference = Boolean.FALSE;
    private Boolean oneToOne = Boolean.FALSE;
    private Boolean oneToMany = Boolean.FALSE;
    private Boolean manyToMany = Boolean.FALSE;

    private CopyOnWriteArrayList<Listener> propertyListeners;
    private CopyOnWriteArrayList<Validator> propertyValidators;

    /**
     * Add property listeners
     *
     * @param listeners listeners
     */
    public void addPropertyListeners(Listener... listeners) {
        if (listeners.length == 1) {
            this.propertyListeners.add(listeners[0]);
        } else {
            this.propertyListeners.addAll(Arrays.asList(listeners));
        }
    }

    /**
     * Add property validators.
     *
     * @param validators validators
     */
    public void addPropertyValidators(Validator... validators) {
        if (validators.length == 1) {
            this.propertyValidators.add(validators[0]);
        } else {
            this.propertyValidators.addAll(Arrays.asList(validators));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getNotNull() {
        return notNull;
    }

    public void setNotNull(Boolean notNull) {
        this.notNull = notNull;
    }

    public Boolean getArray() {
        return array;
    }

    public void setArray(Boolean array) {
        this.array = array;
    }

    public Boolean getReference() {
        return reference;
    }

    public void setReference(Boolean reference) {
        this.reference = reference;
    }

    public Boolean getOneToOne() {
        return oneToOne;
    }

    public void setOneToOne(Boolean oneToOne) {
        this.oneToOne = oneToOne;
    }

    public Boolean getOneToMany() {
        return oneToMany;
    }

    public void setOneToMany(Boolean oneToMany) {
        this.oneToMany = oneToMany;
    }

    public Boolean getManyToMany() {
        return manyToMany;
    }

    public void setManyToMany(Boolean manyToMany) {
        this.manyToMany = manyToMany;
    }

    public List<Listener> getPropertyListeners() {
        return propertyListeners;
    }

    public void setPropertyListeners(List<Listener> propertyListeners) {
        this.propertyListeners = new CopyOnWriteArrayList<Listener>(propertyListeners);
    }

    public List<Validator> getPropertyValidators() {
        return propertyValidators;
    }

    public void setPropertyValidators(List<Validator> propertyValidators) {
        this.propertyValidators = new CopyOnWriteArrayList<Validator>(propertyValidators);
    }
}
