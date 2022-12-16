module com.klebermagno.application {
    requires com.klebermagno.api.impl;
    requires com.klebermagno.serviceimpl;
    requires  com.klebermagno.service;
    requires com.google.guice;
    requires javax.inject;
    requires com.klebermagno.api;
    uses com.klebermagno.api.Bank;
    //exports com.klebermagno.application;
}
