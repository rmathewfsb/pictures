/*
 *    Copyright &copy; Flagstar Bank 2017.
 *
 *    Copyright in the application source code, and in the information and
 *    material therein and in their arrangement, is owned by Flagstar Bank, FSB
 *    unless otherwise indicated.
 *
 *    You shall not remove or obscure any copyright, trademark or other notices.
 *    You may not copy, republish, redistribute, transmit, participate in the
 *    transmission of, create derivatives of, alter edit or exploit in any
 *    manner any material including by storage on retrieval systems, without the
 *    express written permission of Flagstar Bank.
 */
package edu.codeanywhere.j4.pictures.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Picture entity.
 *
 * @author rmathew
 */
@Entity
@Table(name="picture")
public class Picture implements Serializable
{
    /**
     * Private field that ___
     */
    private static final long serialVersionUID = 1416045260929377763L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="TYPE")    
    private String type;
    @Column(name="OWNER")    
    private String owner;
    @Column(name="DATE")    
    private String date;
    @Column(name="SIZE")    
    private Long size;
    public String getName()
    {
        return name;
    }
    public void setName(final String name)
    {
        this.name = name;
    }
    public String getType()
    {
        return type;
    }
    public void setType(final String type)
    {
        this.type = type;
    }
    public String getOwner()
    {
        return owner;
    }
    public void setOwner(final String owner)
    {
        this.owner = owner;
    }
    public String getDate()
    {
        return date;
    }
    public void setDate(final String date)
    {
        this.date = date;
    }
    public Long getSize()
    {
        return size;
    }
    public void setSize(final Long size)
    {
        this.size = size;
    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Picture other = (Picture) obj;
        if (date == null)
        {
            if (other.date != null)
                return false;
        }
        else if (!date.equals(other.date))
            return false;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (owner == null)
        {
            if (other.owner != null)
                return false;
        }
        else if (!owner.equals(other.owner))
            return false;
        if (size == null)
        {
            if (other.size != null)
                return false;
        }
        else if (!size.equals(other.size))
            return false;
        if (type == null)
        {
            if (other.type != null)
                return false;
        }
        else if (!type.equals(other.type))
            return false;
        return true;
    }
}

