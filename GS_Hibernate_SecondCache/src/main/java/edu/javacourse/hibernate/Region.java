package edu.javacourse.hibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
// Аннотация необходима для работы кжша. Отключать при отклюении кэша
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "CacheForRegion")
@Table(name = "jc_region")
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long regionId;


    @Column(name = "region_name", nullable = true)
    private String regionName;

    public Region() {
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return regionId + ":" + regionName;
    }
}
