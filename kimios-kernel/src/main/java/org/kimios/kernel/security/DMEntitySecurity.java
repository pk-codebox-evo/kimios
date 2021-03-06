/*
 * Kimios - Document Management System Software
 * Copyright (C) 2008-2015  DevLib'
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * aong with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kimios.kernel.security;

import org.kimios.exceptions.ConfigException;
import org.kimios.kernel.dms.DMEntity;
import org.kimios.kernel.exception.DataSourceException;

import java.io.Serializable;

public class DMEntitySecurity implements Serializable
{
    private long dmEntityUid;

    private int dmEntityType;

    private String name;

    private String source;

    private String fullName;

    private int type;

    private boolean read;

    private boolean write;

    private boolean fullAccess;

    private DMEntity entity;

    public DMEntitySecurity()
    {
    }

    public DMEntitySecurity(long dmEntityUid, int dmEntityType, String name, String source, int type, boolean read,
            boolean write, boolean fullAccess)
    {
        this.dmEntityUid = dmEntityUid;
        this.dmEntityType = dmEntityType;
        this.name = name;
        this.source = source;
        this.type = type;
        this.read = read;
        this.write = write;
        this.fullAccess = fullAccess;
    }

    public DMEntitySecurity(long dmEntityUid, int dmEntityType, String name, String fullName, String source, int type,
            boolean read, boolean write, boolean fullAccess)
    {
        this.dmEntityUid = dmEntityUid;
        this.dmEntityType = dmEntityType;
        this.name = name;
        this.source = source;
        this.type = type;
        this.read = read;
        this.write = write;
        this.fullAccess = fullAccess;
        this.fullName = fullName;
    }

    public DMEntitySecurity(long dmEntityUid, int dmEntityType, String name, String source, int type, boolean read,
            boolean write, boolean fullAccess, DMEntity entity)
    {
        this.dmEntityUid = dmEntityUid;
        this.dmEntityType = dmEntityType;
        this.name = name;
        this.source = source;
        this.type = type;
        this.read = read;
        this.write = write;
        this.fullAccess = fullAccess;
        this.entity = entity;
    }

    public DMEntitySecurity(long dmEntityUid, int dmEntityType, String name, String source, String fullName, int type,
            boolean read, boolean write, boolean fullAccess, DMEntity entity)
    {
        this.dmEntityUid = dmEntityUid;
        this.dmEntityType = dmEntityType;
        this.name = name;
        this.source = source;
        this.type = type;
        this.read = read;
        this.write = write;
        this.fullAccess = fullAccess;
        this.entity = entity;
        this.fullName = fullName;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public void setFullAccess(boolean fullAccess)
    {
        this.fullAccess = fullAccess;
    }

    public boolean isFullAccess()
    {
        return this.fullAccess;
    }

    public DMEntity getDmEntity() throws ConfigException, DataSourceException
    {
        return this.entity;
    }

    public void setDmEntity(DMEntity dmEntity)
    {
        this.entity = dmEntity;
        this.dmEntityUid = dmEntity.getUid();
        this.dmEntityType = dmEntity.getType();
    }

    public int getDmEntityType()
    {
        return dmEntityType;
    }

    public void setDmEntityType(int dmEntityType)
    {
        this.dmEntityType = dmEntityType;
    }

    public long getDmEntityUid()
    {
        return dmEntityUid;
    }

    public void setDmEntityUid(long dmEntityUid)
    {
        this.dmEntityUid = dmEntityUid;
    }

    public boolean isRead()
    {
        return read;
    }

    public void setRead(boolean read)
    {
        this.read = read;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public boolean isWrite()
    {
        return write;
    }

    public void setWrite(boolean write)
    {
        this.write = write;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public org.kimios.kernel.ws.pojo.DMEntitySecurity toPojo()
    {
        return new org.kimios.kernel.ws.pojo.DMEntitySecurity(
                this.dmEntityUid,
                this.dmEntityType,
                this.name,
                this.source,
                this.fullName,
                this.type,
                this.read,
                this.write,
                this.fullAccess);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DMEntitySecurity security = (DMEntitySecurity) o;

        if (dmEntityUid != security.dmEntityUid) return false;
        if (dmEntityType != security.dmEntityType) return false;
        if (type != security.type) return false;
        if (read != security.read) return false;
        if (write != security.write) return false;
        if (fullAccess != security.fullAccess) return false;
        if (!name.equals(security.name)) return false;
        if (!source.equals(security.source)) return false;
        return fullName.equals(security.fullName);

    }

    @Override
    public int hashCode() {
        int result = (int) (dmEntityUid ^ (dmEntityUid >>> 32));
        result = 31 * result + dmEntityType;
        result = 31 * result + name.hashCode();
        result = 31 * result + source.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + type;
        result = 31 * result + (read ? 1 : 0);
        result = 31 * result + (write ? 1 : 0);
        result = 31 * result + (fullAccess ? 1 : 0);
        return result;
    }
}

