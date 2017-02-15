/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module("HelpApp", [])
        .value('urlBase', 'http://localhost:8080/mavenproject3/rest/')
        .controller("LlamadoController", function ($http, urlBase) {
            var self = this;
            self.usuario = 'Kevin Zambrano';

            self.llamados = [];

            self.llamado = undefined;

            self.novo = function () {
                self.llamado = {};
            };

            self.salvar = function () {
                var metodo = 'POST';
                if (self.llamado.id) {
                    metodo = 'PUT';
                }

                $http({
                    method: metodo,
                    url: urlBase + 'llamados/',
                    data: self.llamado
                }).then(function successCallback(response) {
                    self.actualizarTabela();
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.alterar = function (llamado) {
                self.llamado = llamado;
            };

            self.deletar = function (llamado) {
                self.llamado = llamado;

                $http({
                    method: 'DELETE',
                    url: urlBase + 'llamados/' + self.llamado.id + '/'
                }).then(function successCallback(response) {
                    self.atualizarTabela();
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.concluir = function () {
                alert("TO DO");
            };

            self.ocorreuErro = function () {
                alert("Ocurrio un error inesperado!");
            };

            self.actualizarTabela = function () {
                $http({
                    method: 'GET',
                    url: urlBase + 'llamados/'
                }).then(function successCallback(response) {
                    self.llamados = response.data;
                    self.llamado = undefined;
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.activate = function () {
                self.actualizarTabela();
            };

            self.activate();
        });