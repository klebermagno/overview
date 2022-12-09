module com.klebermagno.application {
    requires com.klebermagno.api.impl;
    requires com.klebermagno.serviceimpl;
    requires com.google.guice;
    requires javax.inject;
    exports com.klebermagno.application;
}
