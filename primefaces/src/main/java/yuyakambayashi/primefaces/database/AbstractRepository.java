/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuyakambayashi.primefaces.database;

import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;

/**
 *
 * @author yuya-kambayashi
 */
public abstract class AbstractRepository<T> {
    private final Class<T> entityClass;
//    private static final Logger logger = LoggerFactory.getLogger(AbstractRepository.class);
    

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        //  バリデーションチェック
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate( entity );
        for (ConstraintViolation<T> err : violations ) 
        {
            String strPathName = "";
            Iterator<Path.Node> iterator = err.getPropertyPath().iterator();
            while (iterator.hasNext()) {
                strPathName += iterator.next().getName() + ",";
            }
            
//            Log.error(logger, "バリデーションチェック：" + strPathName + ":" + err.getInvalidValue() + ":" + err.getMessage());
        }          
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        //  バリデーションチェック
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate( entity );
        for (ConstraintViolation<T> err : violations ) 
        {
            String strPathName = "";
            Iterator<Path.Node> iterator = err.getPropertyPath().iterator();
            while (iterator.hasNext()) {
                strPathName += iterator.next().getName() + ",";
            }            
//            Log.error(logger, "バリデーションチェック：" + strPathName + ":" + err.getInvalidValue() + ":" + err.getMessage());
        }          
        getEntityManager().merge(entity);
    }
    
    public void flush(){
        getEntityManager().flush();
    }

    public void refresh(Object entity){
        getEntityManager().refresh(entity);
    }
    public void detach(Object entity){
        getEntityManager().detach(entity);
    }
    public void clear(){
        getEntityManager().clear();
    }
    
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        jakarta.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        jakarta.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        jakarta.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        jakarta.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        jakarta.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        jakarta.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    protected BooleanExpression query(SimpleExpression col, Object val){
        //nullはeqでは検索できないため下記にて対応
        return val != null ? col.eq(val) : col.isNull();
    }
    
    protected BigDecimal toBigDecimal(Double val){
        return val == null ? null : new BigDecimal(val);
    }
}
