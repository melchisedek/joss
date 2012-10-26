package nl.tweeenveertig.openstack.model;

import nl.tweeenveertig.openstack.headers.object.Etag;
import org.apache.http.HttpEntity;

import java.io.IOException;

/**
* Encapsulates the payload that must be uploaded to the ObjectStore. The reason this class exists
* is that it can support in giving information on the payload.
* @author Robert Bor
*/
public abstract class UploadPayload {

    /**
    * Returns the payload as an HttpEntity, so it can be uploaded to the ObjectStore
    * @return HttpEntity of the payload
    */
    public abstract HttpEntity getEntity();

    /**
    * Checks whether the payload must be segmented into two or more separate objects to circumvent
    * the max object size
    * @param segmentationSize size to check the current payload size against
    * @return true if the payload must be segmented
    */
    public abstract boolean mustBeSegmented(Long segmentationSize);

    /**
    * Returns the MD5 hash value in an Etag header
    * @return Etag header with MD5 hash
    */
    public abstract Etag getEtag() throws IOException;

}
