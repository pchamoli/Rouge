package dao;

import interfaces.LocalDAO;
import interfaces.NegocioDAO;
import interfaces.OpinionDAO;
import interfaces.UsuarioDAO;
import factory.Factory;

public class MySqlDAOFactory extends Factory {
	
	public UsuarioDAO getUsuarioDAO(){
		return new MySqlUsuarioDAO();
	}

	public NegocioDAO getNegocioDAO(){
		return new MySqlNegocioDAO();
	}
	
	public LocalDAO getLocalDAO(){
		return new MySqlLocalDAO();
	}

	@Override
	public OpinionDAO getOpinionDAO() {
		return new MySqlOpinionDAO();
	}
}
