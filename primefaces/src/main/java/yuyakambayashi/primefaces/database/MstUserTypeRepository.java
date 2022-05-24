/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuyakambayashi.primefaces.database;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import yuyakambayashi.primefaces.entity.MstUserType;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.EclipseLinkTemplates;


/**
 *
 * @author yuya-kambayashi
 */
@Stateless
public class MstUserTypeRepository extends AbstractRepository<MstUserType> {

    @PersistenceContext(unitName = "jp.co.kke.config_StandardCPQ_war_1.3.0PU")
    private EntityManager em;

    public MstUserTypeRepository() {
        super(MstUserType.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    private JPQLQuery jpaQuery() {
        return new JPAQuery((javax.persistence.EntityManager) em, EclipseLinkTemplates.DEFAULT);
    }
    
}
