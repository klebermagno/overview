module com.klebermagno.serviceimpl {
    requires com.klebermagno.dto;
    requires transitive com.klebermagno.api;
    requires transitive com.klebermagno.service;
    exports com.klebermagno.serviceimpl;    
}