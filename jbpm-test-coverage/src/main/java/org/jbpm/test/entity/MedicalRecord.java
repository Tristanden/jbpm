/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.test.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MedicalRecord implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String description;
    @OneToOne(optional=false,cascade= CascadeType.ALL)
    @JoinColumn(
    	name="PATIENT_ID", unique=true)
    private Patient patient;
    
    @OneToMany(cascade= CascadeType.ALL, mappedBy="medicalRecord")
    private List<RecordRow> rows;
    private int priority;

    public MedicalRecord() {
    }

    
    public MedicalRecord(String desc, Patient patient) {
        this.description = desc;
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<RecordRow> getRows() {
        return rows;
    }

    public void setRows(List<RecordRow> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" + "id=" + id + ", desc=" + description + ", patient=" + patient.getId() + ", rows=" + rows + ", priority=" + priority + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MedicalRecord other = (MedicalRecord) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        if (this.rows != other.rows && (this.rows == null || !this.rows.equals(other.rows))) {
            return false;
        }
        if (this.priority != other.priority) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 67 * hash + (this.rows != null ? this.rows.hashCode() : 0);
        hash = 67 * hash + this.priority;
        return hash;
    }
    
    
    
}
