/**
 * All rights reserved -- Copyright 2015 Gluu Inc.
 */
package org.xdi.oxd.server.license;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xdi.oxd.common.CoreUtils;
import org.xdi.oxd.license.client.Jackson;

import java.io.*;

/**
 * @author Yuriy Zabrovarnyy
 * @version 0.9, 12/10/2014
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LicenseFile implements Serializable {

    public static final String LICENSE_FILE_NAME = ".oxd-license";

    public static final String LICENSE_FILE_PATH = LICENSE_FILE_NAME;

    private static final Logger LOG = LoggerFactory.getLogger(LicenseFile.class);

    public static class MacAddress {
        private static String MAC_ADDRESS = null;

        public static synchronized String getMacAddress() {
            return MAC_ADDRESS;
        }

        public static synchronized void setMacAddress(String macAddress) {
            LOG.trace("MAC ADDRESS set to : " + macAddress);
            MacAddress.MAC_ADDRESS = macAddress;
        }
    }

    @JsonProperty(value = "encoded_license")
    private String encodedLicense;
    @JsonProperty(value = "mac_address")
    private String macAddress;
    @JsonProperty(value = "license_id")
    private String licenseId;

    @JsonIgnore
    private long lastModified;

    public LicenseFile() {
    }

    public LicenseFile(String encodedLicense, String macAddress, String licenseId) {
        this.encodedLicense = encodedLicense;
        this.macAddress = macAddress;
        this.licenseId = licenseId;
    }

    public String getEncodedLicense() {
        return encodedLicense;
    }

    public void setEncodedLicense(String encodedLicense) {
        this.encodedLicense = encodedLicense;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    private static LicenseFile create(InputStream p_stream) {
        try {
            try {
                LicenseFile licenseFile = CoreUtils.createJsonMapper().readValue(p_stream, LicenseFile.class);
                if (licenseFile != null) {
                    if (!Strings.isNullOrEmpty(licenseFile.getMacAddress())) {
                        LicenseFile.MacAddress.setMacAddress(licenseFile.getMacAddress());
                    }
                    return licenseFile;
                }
            } catch (Exception e) {
                if (e.getMessage().startsWith("No content to map to Object")) { // quick trick to make it less verbose for empty file
                    LOG.error(e.getMessage());
                } else {
                    LOG.error(e.getMessage(), e);
                }
            }
            return null;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    public static Optional<LicenseFile> load() {
        InputStream inputStream = null;
        try {
            File file = getLicenseFile();
            inputStream = new FileInputStream(file);
            LicenseFile licenseFile = create(inputStream);
            if (licenseFile != null) {
                licenseFile.setLastModified(file.lastModified());
                return Optional.of(licenseFile);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return Optional.absent();
    }

    public static File getLicenseFile() throws IOException {
        File file = new File(LICENSE_FILE_PATH);
        if (!file.exists()) {
            final boolean fileCreated = file.createNewFile();
            if (!fileCreated) {
                throw new RuntimeException("Failed to create license file, path:" + file.getAbsolutePath());
            }
        }
        LOG.debug("License file location: " + file.getAbsolutePath());
        return file;
    }

    public static boolean deleteContent() {
        try {
            final File file = getLicenseFile();
            if (file != null && file.exists()) {
                FileUtils.write(file, "");
                LOG.info("Dropped content of license file");
                return true;
            } else {
                LOG.error("License file does not exist.");
            }
        } catch (IOException e) {
            LOG.error("Failed to remove content of license file.", e);
        }
        return false;
    }


    public static boolean delete() throws IOException {
        return getLicenseFile().delete();
    }

    public static boolean deleteSilently() {
        try {
            return delete();
        } catch (IOException e) {
            LOG.error("Failed to delete license file.", e);
            return false;
        }
    }

    public String asJson() {
        return Jackson.asJsonSilently(this);
    }
}
