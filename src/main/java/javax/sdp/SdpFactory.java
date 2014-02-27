package javax.sdp;

import java.net.URL;
import java.util.Date;
import java.util.Vector;

/**
 * The SdpFactory enables applications to encode and decode SDP messages. The
 * SdpFactory can be used to construct a SessionDescription object
 * programmatically. The SdpFactory can also be used to construct a
 * SessionDescription based on the contents of a String. Acknowledgement: Bugs
 * reported by Brian J. Collins <bjcollins@rockwellcollins.com>. and by Majdi
 * Abuelbassal <majdi.abuelbassal@bbumail.com>. Please refer to IETF RFC 2327
 * for a description of SDP.
 *
 * @author Olivier Deruelle <olivier.deruelle@nist.gov>
 * @author M. Ranganathan
 *
 *
 * @version 1.0
 *
 */
public interface SdpFactory {

    /**
     * Creates a new, empty SessionDescription. The session is set as follows:
     *
     * v=0
     *
     * o=this.createOrigin ("user", InetAddress.getLocalHost().toString());
     *
     * s=-
     *
     * t=0 0
     *
     * @throws SdpException
     *             SdpException, - if there is a problem constructing the
     *             SessionDescription.
     * @return a new, empty SessionDescription.
     */
    public SessionDescription createSessionDescription() throws SdpException;

    /**
     * Creates a SessionDescription populated with the information contained
     * within the string parameter.
     *
     * Note: unknown field types should not cause exceptions.
     *
     * @param s
     *            s - the sdp message that is to be parsed.
     * @throws SdpParseException
     *             SdpParseException - if there is a problem parsing the String.
     * @return a populated SessionDescription object.
     */
    public SessionDescription createSessionDescription(String s)
            throws SdpParseException;

    /**
     * Returns Bandwidth object with the specified values.
     *
     * @param modifier
     *            modifier - the bandwidth type
     * @param value
     *            the bandwidth value measured in kilobits per second
     * @return bandwidth
     */
    public BandWidth createBandwidth(String modifier, int value);

    /**
     * Returns Attribute object with the specified values.
     *
     * @param name
     *            the namee of the attribute
     * @param value
     *            the value of the attribute
     * @return Attribute
     */
    public Attribute createAttribute(String name, String value);

    /**
     * Returns Info object with the specified value.
     *
     * @param value
     *            the string containing the description.
     * @return Info
     */
    public Info createInfo(String value);

    /**
     * Returns Phone object with the specified value.
     *
     * @param value
     *            the string containing the description.
     * @return Phone
     */
    public Phone createPhone(String value);

    /**
     * Returns EMail object with the specified value.
     *
     * @param value
     *            the string containing the description.
     * @return EMail
     */
    public EMail createEMail(String value);

    /**
     * Returns URI object with the specified value.
     *
     * @param value
     *            the URL containing the description.
     * @throws SdpException
     * @return URI
     */
    public javax.sdp.URI createURI(URL value) throws SdpException;

    /**
     * Returns SessionName object with the specified name.
     *
     * @param name
     *            the string containing the name of the session.
     * @return SessionName
     */
    public SessionName createSessionName(String name);

    /**
     * Returns Key object with the specified value.
     *
     * @param method
     *            the string containing the method type.
     * @param key
     *            the key to set
     * @return Key
     */
    public Key createKey(String method, String key);

    /**
     * Returns Version object with the specified values.
     *
     * @param value
     *            the version number.
     * @return Version
     */
    public Version createVersion(int value);

    /**
     * Returns Media object with the specified properties.
     *
     * @param media
     *            the media type, eg "audio"
     * @param port
     *            port number on which to receive media
     * @param numPorts
     *            number of ports used for this media stream
     * @param transport
     *            transport type, eg "RTP/AVP"
     * @param staticRtpAvpTypes
     *            vector to set
     * @throws SdpException
     * @return Media
     */
    public Media createMedia(String media, int port, int numPorts,
            String transport, Vector staticRtpAvpTypes) throws SdpException;

    /**
     * Returns Origin object with the specified properties.
     *
     * @param userName
     *            the user name.
     * @param address
     *            the IP4 encoded address.
     * @throws SdpException
     *             if the parameters are null
     * @return Origin
     */
    public Origin createOrigin(String userName, String address)
            throws SdpException;

    /**
     * Returns Origin object with the specified properties.
     *
     * @param userName
     *            String containing the user that created the string.
     * @param sessionId
     *            long containing the session identifier.
     * @param sessionVersion
     *            long containing the session version.
     * @param networkType
     *            String network type for the origin (usually "IN").
     * @param addrType
     *            String address type (usually "IP4").
     * @param address
     *            String IP address usually the address of the host.
     * @throws SdpException
     *             if the parameters are null
     * @return Origin object with the specified properties.
     */
    public Origin createOrigin(String userName, long sessionId,
            long sessionVersion, String networkType, String addrType,
            String address) throws SdpException;

    /**
     * Returns MediaDescription object with the specified properties. The
     * returned object will respond to Media.getMediaFormats(boolean) with a
     * Vector of media formats.
     *
     * @param media
     *            media -
     * @param port
     *            port number on which to receive media
     * @param numPorts
     *            number of ports used for this media stream
     * @param transport
     *            transport type, eg "RTP/AVP"
     * @param staticRtpAvpTypes
     *            list of static RTP/AVP media payload types which should be
     *            specified by the returned MediaDescription throws
     *            IllegalArgumentException if passed an invalid RTP/AVP payload
     *            type
     * @throws IllegalArgumentException
     * @throws SdpException
     * @return MediaDescription
     */
    public MediaDescription createMediaDescription(String media, int port,
            int numPorts, String transport, int[] staticRtpAvpTypes)
            throws IllegalArgumentException, SdpException;

    /**
     * Returns MediaDescription object with the specified properties. The
     * returned object will respond to Media.getMediaFormats(boolean) with a
     * Vector of String objects specified by the 'formats argument.
     *
     * @param media
     *            the media type, eg "audio"
     * @param port
     *            port number on which to receive media
     * @param numPorts
     *            number of ports used for this media stream
     * @param transport
     *            transport type, eg "RTP/AVP"
     * @param formats
     *            list of formats which should be specified by the returned
     *            MediaDescription
     * @return MediaDescription
     */
    public MediaDescription createMediaDescription(String media, int port,
            int numPorts, String transport, String[] formats) throws  SdpException;

    /**
     * Returns TimeDescription object with the specified properties.
     *
     * @param t
     *            the Time that the time description applies to. Returns
     *            TimeDescription object with the specified properties.
     * @throws SdpException
     * @return TimeDescription
     */
    public TimeDescription createTimeDescription(Time t) throws SdpException;

    /**
     * Returns TimeDescription unbounded (i.e. "t=0 0");
     *
     * @throws SdpException
     * @return TimeDescription unbounded (i.e. "t=0 0");
     */
    public TimeDescription createTimeDescription() throws SdpException;

    /**
     * Returns TimeDescription object with the specified properties.
     *
     * @param start
     *            start time.
     * @param stop
     *            stop time.
     * @throws SdpException
     *             if the parameters are null
     * @return TimeDescription
     */
    public TimeDescription createTimeDescription(Date start, Date stop)
            throws SdpException;

    /**
     * Returns a String containing the computed form for a multi-connection
     * address. Parameters: addr - connection address ttl - time to live (TTL)
     * for multicast addresses numAddrs - number of addresses used by the
     * connection Returns: a String containing the computed form for a
     * multi-connection address.
     */
    public String formatMulticastAddress(String addr, int ttl, int numAddrs);

    /**
     * Returns a Connection object with the specified properties a
     *
     * @param netType
     *            network type, eg "IN" for "Internet"
     * @param addrType
     *            address type, eg "IP4" for IPv4 type addresses
     * @param addr
     *            connection address
     * @param ttl
     *            time to live (TTL) for multicast addresses
     * @param numAddrs
     *            number of addresses used by the connection
     * @return Connection
     */
    public Connection createConnection(String netType, String addrType,
            String addr, int ttl, int numAddrs) throws SdpException;

    /**
     * Returns a Connection object with the specified properties and no TTL and
     * a default number of addresses (1).
     *
     * @param netType
     *            network type, eg "IN" for "Internet"
     * @param addrType
     *            address type, eg "IP4" for IPv4 type addresses
     * @param addr
     *            connection address
     * @throws SdpException
     *             if the parameters are null
     * @return Connection
     */
    public Connection createConnection(String netType, String addrType,
            String addr) throws SdpException;

    /**
     * Returns a Connection object with the specified properties and a network
     * and address type of "IN" and "IP4" respectively.
     *
     * @param addr
     *            connection address
     * @param ttl
     *            time to live (TTL) for multicast addresses
     * @param numAddrs
     *            number of addresses used by the connection
     * @return Connection
     */
    public Connection createConnection(String addr, int ttl, int numAddrs)
            throws SdpException;

    /**
     * Returns a Connection object with the specified address. This is
     * equivalent to
     *
     * createConnection("IN", "IP4", addr);
     *
     * @param addr
     *            connection address
     * @throws SdpException
     *             if the parameter is null
     * @return Connection
     */
    public Connection createConnection(String addr) throws SdpException;

    /**
     * Returns a Time specification with the specified start and stop times.
     *
     * @param start
     *            start time
     * @param stop
     *            stop time
     * @throws SdpException
     *             if the parameters are null
     * @return a Time specification with the specified start and stop times.
     */
    public Time createTime(Date start, Date stop) throws SdpException;

    /**
     * Returns an unbounded Time specification (i.e., "t=0 0").
     *
     * @throws SdpException
     * @return an unbounded Time specification (i.e., "t=0 0").
     */
    public Time createTime() throws SdpException;

    /**
     * Returns a RepeatTime object with the specified interval, duration, and
     * time offsets.
     *
     * @param repeatInterval
     *            the "repeat interval" in seconds
     * @param activeDuration
     *            the "active duration" in seconds
     * @param offsets
     *            the list of offsets relative to the start time of the Time
     *            object with which the returned RepeatTime will be associated
     * @return RepeatTime
     */
    public RepeatTime createRepeatTime(int repeatInterval, int activeDuration,
            int[] offsets);

    /**
     * Constructs a timezone adjustment record.
     *
     * @param d
     *            the Date at which the adjustment is going to take place.
     * @param offset
     *            the adjustment in number of seconds relative to the start time
     *            of the SessionDescription with which this object is
     *            associated.
     * @return TimeZoneAdjustment
     */
    public TimeZoneAdjustment createTimeZoneAdjustment(Date d, int offset);

    /**
     * Returns a collection of Strings containing session description.
     * @param source
     *            String containing session descriptions.
     * @return a collection of Strings containing session descriptions.
     */
    public Vector findSessions(String source);

    /**
     * @param ntpTime
     *            long to set
     * @return Returns a Date object for a given NTP date value.
     */
    public Date getDateFromNtp(long ntpTime);

    /**
     * Returns a long containing the NTP value for a given Java Date.
     *
     * @param d
     *            Date to set
     * @return long
     */
    public long getNtpTime(Date d);

}
