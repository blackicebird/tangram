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
     private Boolean reference  = Boolean.FALSE;
     private Boolean oneToOne  = Boolean.FALSE;
     private Boolean oneToMany  = Boolean.FALSE;
     private Boolean manyToMany  = Boolean.FALSE;
}
