package application.domain.exceptions; public class NotFoundException extends DomainRuleException { public NotFoundException(String type,String id){super(type+" not found: "+id);} }
