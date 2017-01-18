package aop01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aop01.model.ModelProduct;

public class FirstAspect {
    
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(FirstAspect.class);
    
    public void before( JoinPoint jp ) {
        logger.debug( "before ----> 메서드그 호출 되기 전");
        logger.debug( "before ----> 호출되는 메서드는 " + jp.getSignature().getName() );
        logger.debug( "before ----> 매개변수는 " + jp.getArgs().toString() );
    }

    // 반환값이 없는 경우에 사용됨.
    public void after(  ) {
        logger.debug( "after ----> 메서드그 호출된 후");
        logger.debug( "after ----> 메서드그 호출된 후");
        logger.debug( "after ----> 메서드그 호출된 후");
    }

    // 반환값이 있는 경우에 사용됨.
    public void afterReturning( JoinPoint jp, ModelProduct product  ) {
        logger.debug( "afterReturning ----> 메서드가 return 되었을 때");
        logger.debug( "afterReturning ----> 호출된 메서드는 " + jp.getSignature().getName() );
        logger.debug( "afterReturning ----> 매개변수는 " + jp.getArgs().toString() );
    }

    // 메서드가 호출되는 경우에 사용됨.
    public ModelProduct around( ProceedingJoinPoint jp ) throws Throwable {
        logger.debug( "around ----> before가 호출되기 전에 실행됨.");
        logger.debug( "around ----> before *** aop:around 메서드 이름은 " + jp.getSignature().getName() );
       
        ModelProduct p = (ModelProduct)jp.proceed();
        
        logger.debug( "around ----> after 가 호출된 후에 실행됨.");
        logger.debug( "around ----> after 가 호출된 후에 실행됨."); 
        
        return p;
    }
    
    // 예외가 발생 했을 때
    public void afterThrowing( Throwable e ) {

        logger.debug( "afterThrowing ----> exception value = " + e.getMessage() );
        logger.debug( "afterThrowing ----> exception 이 생기면 나온다." );
        logger.debug( "afterThrowing ----> exception 이 생기면 나온다." );
    }
}
