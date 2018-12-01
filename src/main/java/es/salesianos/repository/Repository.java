package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Actor;
import es.salesianos.model.Owner;
import es.salesianos.model.Pet;



public class Repository {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Owner search(Owner ownerFormulario) {
		Owner ownerInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM OWNER WHERE codOwner = ?");
			prepareStatement.setInt(1, ownerFormulario.getCodOwner());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				ownerInDatabase = new Owner();
				ownerInDatabase.setCodOwner(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
			
		}
		manager.close(conn);
		return ownerInDatabase;
	}

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void insert(Actor actor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO actores (lugarNacimiento,nomActor,apellidos)" +
					"VALUES (?, ?,?)");
			preparedStatement.setString(1, actor.getLugarNacimiento());
			preparedStatement.setString(2, actor.getNomActor());
			preparedStatement.setString(3, actor.getApellidos());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}
		
		
		manager.close(conn);
	}

	public void update(Owner ownerFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE OWNER SET name = ?,surname = ? WHERE codOwner = ?");
			preparedStatement.setString(1, ownerFormulario.getName());
			preparedStatement.setString(2, ownerFormulario.getSurname());
			preparedStatement.setInt(3, ownerFormulario.getCodOwner());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public void delete(Integer codOwner) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			
			preparedStatement = deletePetsFor(codOwner, conn);
			
			preparedStatement = deleteOwner(codOwner, conn);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	private PreparedStatement deleteOwner(Integer codOwner, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM OWNER WHERE codOwner = ?");
		preparedStatement.setInt(1, codOwner);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	private PreparedStatement deletePetsFor(Integer codOwner, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM PET WHERE codOwner = ?");
		preparedStatement.setInt(1, codOwner);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	public List<Actor> searchAll() {
		List<Actor> listOwners = new ArrayList<Actor>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			/*
			prepareStatement = conn.prepareStatement("
			SELECT * FROM OWNER o, PET p INNER JOIN WHERE o.codOwner = p.codOwner");
			while (resultSet.next()) {
				Owner ownerInDatabase = new Owner();
				ownerInDatabase.setCodOwner(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
				Pet pet = new Pet();
				pet.setName(resultSet.getString(4)) 
				pet.setCodOwner(resultSet.getString(5)) 
				ownerInDatabase.getMascotas().add(pet)
				listOwners.add(ownerInDatabase);
			}
			 */
			
			prepareStatement = conn.prepareStatement("SELECT * FROM actores");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Actor ownerInDatabase = new Actor();
				ownerInDatabase.setCodActor(resultSet.getInt(1));;
				ownerInDatabase.setLugarNacimiento(resultSet.getString(2));
				ownerInDatabase.setNomActor(resultSet.getString(3));;
				ownerInDatabase.setApellidos(resultSet.getString(4));;
				
				listOwners.add(ownerInDatabase);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listOwners;
	}
	
	public Owner searchByCodOwner(Integer codOwner) {
		Owner ownerInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM OWNER WHERE codOwner = ?");
			prepareStatement.setInt(1, codOwner);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				ownerInDatabase = new Owner();
				ownerInDatabase.setCodOwner(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return ownerInDatabase;
	}

	public void insertPet(Pet pet) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO PET (petName,codOwner)" +
					"VALUES (?, ?)");
			preparedStatement.setString(1, pet.getName());
			preparedStatement.setInt(2, pet.getCodOwner());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}
		
		
		manager.close(conn);
		
	}
	
	public List<Pet> searchAllPets() {
		List<Pet> listPets = new ArrayList<Pet>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM PET WHERE codOwner=?");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Pet petInDatabase = new Pet();
				
				petInDatabase.setName(resultSet.getString(1));
				petInDatabase.setCodOwner(resultSet.getInt(2));
				

				listPets.add(petInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listPets;
	}

	public Owner searchAndDelete(Integer codOwner,String PetName) {
		Owner ownerInDatabase = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM PET WHERE codOwner = ? AND petName = ?");
			prepareStatement.setInt(1, codOwner);
			prepareStatement.setString(2, PetName);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
		}
		manager.close(conn);
		return ownerInDatabase;
	}


	public Pet search(Integer codOwner, String petName) {
		Pet petInDataBase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM PET WHERE codOwner = ? AND petName = ? ");
			prepareStatement.setInt(1, codOwner);
			prepareStatement.setString(2, petName);

			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				petInDataBase = new Pet();
				petInDataBase.setName(resultSet.getString(1));
				petInDataBase.setCodOwner(resultSet.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return petInDataBase;		
	}

	public void updatePet(Pet pet , Object antiguoName) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE PET SET petName = ? WHERE codOwner = ? AND petName = ?");
			preparedStatement.setString(1, pet.getName());
			preparedStatement.setInt(2, pet.getCodOwner());
			preparedStatement.setString(3, (String)antiguoName);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}		
	}

	public List<Owner> searchAllByPerson(String nombreAbuscar) {
		List<Owner> listOwners = new ArrayList<Owner>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT O.codOwner,O.name,O.surname FROM OWNER AS O, PET AS P WHERE O.codOwner=P.codOwner AND P.petName = ?");
			prepareStatement.setString(1, nombreAbuscar);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("LLEGA");
				Owner ownerInDatabase = new Owner();
				ownerInDatabase.setCodOwner(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
				listOwners.add(ownerInDatabase);
			}
			
			for (Owner owner : listOwners) {

				
				prepareStatement = conn.prepareStatement(
						"SELECT * FROM PET where codOwner="+owner.getCodOwner());
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Pet pet = new Pet();
					pet.setName(resultSet.getString(1));
					pet.setCodOwner(resultSet.getInt(2));
					owner.getMascotas().add(pet);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listOwners;
	
	}

}
