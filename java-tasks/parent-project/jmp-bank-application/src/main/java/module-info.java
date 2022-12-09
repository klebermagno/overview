module com.klebermagno.application {
    requires com.klebermagno.api.impl;
    requires com.klebermagno.serviceimpl;
    opens com.google.inject;
    exports com.klebermagno.application;
}
