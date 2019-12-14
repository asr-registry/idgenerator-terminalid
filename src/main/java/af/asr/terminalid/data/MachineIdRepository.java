package af.asr.terminalid.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository class for {@link MachineId}.
 *
 */
@Repository
public interface MachineIdRepository extends JpaRepository<MachineId, Integer> {

	/**
	 * Method to generate the last generate MID.
	 * 
	 * @return the MID entity response.
	 */
	@Query(value = "select t.curr_seq_no,t.cr_by,t.cr_dtimes,t.upd_by,t.upd_dtimes FROM master.mid_seq t where t.curr_seq_no=(select max(t.curr_seq_no) FROM master.mid_seq t)", nativeQuery = true)
	MachineId findLastMID();

}
