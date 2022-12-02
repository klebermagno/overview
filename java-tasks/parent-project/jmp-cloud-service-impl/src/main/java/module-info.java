module com.klebermagno.serviceimpl {
    requires com.klebermagno.dto;
    requires transitive com.klebermagno.api;
    requires transitive om.klebermagno.service;
    exports com.klebermagno.serviceimpl;    
}