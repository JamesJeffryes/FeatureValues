package us.kbase.kbasefeaturevalues;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import us.kbase.auth.AuthToken;
import us.kbase.common.service.JsonClientCaller;
import us.kbase.common.service.JsonClientException;
import us.kbase.common.service.UnauthorizedException;

/**
 * <p>Original spec-file module name: KBaseFeatureValues</p>
 * <pre>
 * The KBaseFeatureValues set of data types and service provides a mechanism for
 * representing numeric values associated with genome features and conditions, together
 * with some basic operations on this data.  Essentially, the data is stored as a simple
 * 2D matrix of floating point numbers.  Currently, this is exposed as support for
 * expression data and single gene knockout fitness data.  (Fitness data being growth
 * rate relative to WT growth with the specified single gene knockout in a specified
 * condition).
 * The operations supported on this data is simple clustering of genes and clustering 
 * related tools.
 * </pre>
 */
public class KBaseFeatureValuesClient {
    private JsonClientCaller caller;


    /** Constructs a client with a custom URL and no user credentials.
     * @param url the URL of the service.
     */
    public KBaseFeatureValuesClient(URL url) {
        caller = new JsonClientCaller(url);
    }
    /** Constructs a client with a custom URL.
     * @param url the URL of the service.
     * @param token the user's authorization token.
     * @throws UnauthorizedException if the token is not valid.
     * @throws IOException if an IOException occurs when checking the token's
     * validity.
     */
    public KBaseFeatureValuesClient(URL url, AuthToken token) throws UnauthorizedException, IOException {
        caller = new JsonClientCaller(url, token);
    }

    /** Constructs a client with a custom URL.
     * @param url the URL of the service.
     * @param user the user name.
     * @param password the password for the user name.
     * @throws UnauthorizedException if the credentials are not valid.
     * @throws IOException if an IOException occurs when checking the user's
     * credentials.
     */
    public KBaseFeatureValuesClient(URL url, String user, String password) throws UnauthorizedException, IOException {
        caller = new JsonClientCaller(url, user, password);
    }

    /** Get the token this client uses to communicate with the server.
     * @return the authorization token.
     */
    public AuthToken getToken() {
        return caller.getToken();
    }

    /** Get the URL of the service with which this client communicates.
     * @return the service URL.
     */
    public URL getURL() {
        return caller.getURL();
    }

    /** Set the timeout between establishing a connection to a server and
     * receiving a response. A value of zero or null implies no timeout.
     * @param milliseconds the milliseconds to wait before timing out when
     * attempting to read from a server.
     */
    public void setConnectionReadTimeOut(Integer milliseconds) {
        this.caller.setConnectionReadTimeOut(milliseconds);
    }

    /** Check if this client allows insecure http (vs https) connections.
     * @return true if insecure connections are allowed.
     */
    public boolean isInsecureHttpConnectionAllowed() {
        return caller.isInsecureHttpConnectionAllowed();
    }

    /** Deprecated. Use isInsecureHttpConnectionAllowed().
     * @deprecated
     */
    public boolean isAuthAllowedForHttp() {
        return caller.isAuthAllowedForHttp();
    }

    /** Set whether insecure http (vs https) connections should be allowed by
     * this client.
     * @param allowed true to allow insecure connections. Default false
     */
    public void setIsInsecureHttpConnectionAllowed(boolean allowed) {
        caller.setInsecureHttpConnectionAllowed(allowed);
    }

    /** Deprecated. Use setInsecureHttpConnectionAllowed().
     * @deprecated
     */
    public void setAuthAllowedForHttp(boolean isAuthAllowedForHttp) {
        caller.setAuthAllowedForHttp(isAuthAllowedForHttp);
    }

    /** Set whether all SSL certificates, including self-signed certificates,
     * should be trusted.
     * @param trustAll true to trust all certificates. Default false.
     */
    public void setAllSSLCertificatesTrusted(final boolean trustAll) {
        caller.setAllSSLCertificatesTrusted(trustAll);
    }
    
    /** Check if this client trusts all SSL certificates, including
     * self-signed certificates.
     * @return true if all certificates are trusted.
     */
    public boolean isAllSSLCertificatesTrusted() {
        return caller.isAllSSLCertificatesTrusted();
    }
    /** Sets streaming mode on. In this case, the data will be streamed to
     * the server in chunks as it is read from disk rather than buffered in
     * memory. Many servers are not compatible with this feature.
     * @param streamRequest true to set streaming mode on, false otherwise.
     */
    public void setStreamingModeOn(boolean streamRequest) {
        caller.setStreamingModeOn(streamRequest);
    }

    /** Returns true if streaming mode is on.
     * @return true if streaming mode is on.
     */
    public boolean isStreamingModeOn() {
        return caller.isStreamingModeOn();
    }

    public void _setFileForNextRpcResponse(File f) {
        caller.setFileForNextRpcResponse(f);
    }

    /**
     * <p>Original spec-file function name: estimate_k</p>
     * <pre>
     * Used as an analysis step before generating clusters using K-means clustering, this method
     * provides an estimate of K by [...]
     * </pre>
     * @param   params   instance of type {@link us.kbase.kbasefeaturevalues.EstimateKParams EstimateKParams}
     * @return   parameter "job_id" of String
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public String estimateK(EstimateKParams params) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<String>> retType = new TypeReference<List<String>>() {};
        List<String> res = caller.jsonrpcCall("KBaseFeatureValues.estimate_k", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: cluster_k_means</p>
     * <pre>
     * Clusters features by K-means clustering.
     * </pre>
     * @param   params   instance of type {@link us.kbase.kbasefeaturevalues.ClusterKMeansParams ClusterKMeansParams}
     * @return   parameter "job_id" of String
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public String clusterKMeans(ClusterKMeansParams params) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<String>> retType = new TypeReference<List<String>>() {};
        List<String> res = caller.jsonrpcCall("KBaseFeatureValues.cluster_k_means", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: cluster_hierarchical</p>
     * <pre>
     * Clusters features by hierarchical clustering.
     * </pre>
     * @param   params   instance of type {@link us.kbase.kbasefeaturevalues.ClusterHierarchicalParams ClusterHierarchicalParams}
     * @return   parameter "job_id" of String
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public String clusterHierarchical(ClusterHierarchicalParams params) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<String>> retType = new TypeReference<List<String>>() {};
        List<String> res = caller.jsonrpcCall("KBaseFeatureValues.cluster_hierarchical", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: clusters_from_dendrogram</p>
     * <pre>
     * Given a ClusterSet with a dendogram built from a hierarchical clustering
     * method, this function creates new clusters by cutting the dendogram at
     * a specific hieght or by some other approach.
     * </pre>
     * @param   params   instance of type {@link us.kbase.kbasefeaturevalues.ClustersFromDendrogramParams ClustersFromDendrogramParams}
     * @return   parameter "job_id" of String
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public String clustersFromDendrogram(ClustersFromDendrogramParams params) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<String>> retType = new TypeReference<List<String>>() {};
        List<String> res = caller.jsonrpcCall("KBaseFeatureValues.clusters_from_dendrogram", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: evaluate_clusterset_quality</p>
     * <pre>
     * Given a ClusterSet with a dendogram built from a hierarchical clustering
     * method, this function creates new clusters by cutting the dendogram at
     * a specific hieght or by some other approach.
     * </pre>
     * @param   params   instance of type {@link us.kbase.kbasefeaturevalues.EvaluateClustersetQualityParams EvaluateClustersetQualityParams}
     * @return   parameter "job_id" of String
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public String evaluateClustersetQuality(EvaluateClustersetQualityParams params) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<String>> retType = new TypeReference<List<String>>() {};
        List<String> res = caller.jsonrpcCall("KBaseFeatureValues.evaluate_clusterset_quality", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: validate_matrix</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.kbasefeaturevalues.ValidateMatrixParams ValidateMatrixParams}
     * @return   parameter "job_id" of String
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public String validateMatrix(ValidateMatrixParams params) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<String>> retType = new TypeReference<List<String>>() {};
        List<String> res = caller.jsonrpcCall("KBaseFeatureValues.validate_matrix", args, retType, true, false);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: correct_matrix</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.kbasefeaturevalues.CorrectMatrixParams CorrectMatrixParams}
     * @return   parameter "job_id" of String
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public String correctMatrix(CorrectMatrixParams params) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<String>> retType = new TypeReference<List<String>>() {};
        List<String> res = caller.jsonrpcCall("KBaseFeatureValues.correct_matrix", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: status</p>
     * <pre>
     * </pre>
     * @return   instance of type {@link us.kbase.kbasefeaturevalues.ServiceStatus ServiceStatus}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public ServiceStatus status() throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        TypeReference<List<ServiceStatus>> retType = new TypeReference<List<ServiceStatus>>() {};
        List<ServiceStatus> res = caller.jsonrpcCall("KBaseFeatureValues.status", args, retType, true, false);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: reconnect_matrix_to_genome</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.kbasefeaturevalues.ReconnectMatrixToGenomeParams ReconnectMatrixToGenomeParams}
     * @return   parameter "job_id" of String
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public String reconnectMatrixToGenome(ReconnectMatrixToGenomeParams params) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<String>> retType = new TypeReference<List<String>>() {};
        List<String> res = caller.jsonrpcCall("KBaseFeatureValues.reconnect_matrix_to_genome", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: build_feature_set</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.kbasefeaturevalues.BuildFeatureSetParams BuildFeatureSetParams}
     * @return   parameter "job_id" of String
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public String buildFeatureSet(BuildFeatureSetParams params) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<String>> retType = new TypeReference<List<String>>() {};
        List<String> res = caller.jsonrpcCall("KBaseFeatureValues.build_feature_set", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_matrix_descriptor</p>
     * <pre>
     * </pre>
     * @param   arg1   instance of type {@link us.kbase.kbasefeaturevalues.GetMatrixDescriptorParams GetMatrixDescriptorParams}
     * @return   instance of type {@link us.kbase.kbasefeaturevalues.MatrixDescriptor MatrixDescriptor}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public MatrixDescriptor getMatrixDescriptor(GetMatrixDescriptorParams arg1) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(arg1);
        TypeReference<List<MatrixDescriptor>> retType = new TypeReference<List<MatrixDescriptor>>() {};
        List<MatrixDescriptor> res = caller.jsonrpcCall("KBaseFeatureValues.get_matrix_descriptor", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_matrix_row_descriptors</p>
     * <pre>
     * </pre>
     * @param   arg1   instance of type {@link us.kbase.kbasefeaturevalues.GetMatrixItemDescriptorsParams GetMatrixItemDescriptorsParams}
     * @return   instance of list of type {@link us.kbase.kbasefeaturevalues.ItemDescriptor ItemDescriptor}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public List<ItemDescriptor> getMatrixRowDescriptors(GetMatrixItemDescriptorsParams arg1) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(arg1);
        TypeReference<List<List<ItemDescriptor>>> retType = new TypeReference<List<List<ItemDescriptor>>>() {};
        List<List<ItemDescriptor>> res = caller.jsonrpcCall("KBaseFeatureValues.get_matrix_row_descriptors", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_matrix_column_descriptors</p>
     * <pre>
     * </pre>
     * @param   arg1   instance of type {@link us.kbase.kbasefeaturevalues.GetMatrixItemDescriptorsParams GetMatrixItemDescriptorsParams}
     * @return   instance of list of type {@link us.kbase.kbasefeaturevalues.ItemDescriptor ItemDescriptor}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public List<ItemDescriptor> getMatrixColumnDescriptors(GetMatrixItemDescriptorsParams arg1) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(arg1);
        TypeReference<List<List<ItemDescriptor>>> retType = new TypeReference<List<List<ItemDescriptor>>>() {};
        List<List<ItemDescriptor>> res = caller.jsonrpcCall("KBaseFeatureValues.get_matrix_column_descriptors", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_matrix_rows_stat</p>
     * <pre>
     * </pre>
     * @param   arg1   instance of type {@link us.kbase.kbasefeaturevalues.GetMatrixItemsStatParams GetMatrixItemsStatParams}
     * @return   instance of list of type {@link us.kbase.kbasefeaturevalues.ItemStat ItemStat}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public List<ItemStat> getMatrixRowsStat(GetMatrixItemsStatParams arg1) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(arg1);
        TypeReference<List<List<ItemStat>>> retType = new TypeReference<List<List<ItemStat>>>() {};
        List<List<ItemStat>> res = caller.jsonrpcCall("KBaseFeatureValues.get_matrix_rows_stat", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_matrix_columns_stat</p>
     * <pre>
     * </pre>
     * @param   arg1   instance of type {@link us.kbase.kbasefeaturevalues.GetMatrixItemsStatParams GetMatrixItemsStatParams}
     * @return   instance of list of type {@link us.kbase.kbasefeaturevalues.ItemStat ItemStat}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public List<ItemStat> getMatrixColumnsStat(GetMatrixItemsStatParams arg1) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(arg1);
        TypeReference<List<List<ItemStat>>> retType = new TypeReference<List<List<ItemStat>>>() {};
        List<List<ItemStat>> res = caller.jsonrpcCall("KBaseFeatureValues.get_matrix_columns_stat", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_matrix_row_sets_stat</p>
     * <pre>
     * </pre>
     * @param   arg1   instance of type {@link us.kbase.kbasefeaturevalues.GetMatrixSetsStatParams GetMatrixSetsStatParams}
     * @return   instance of list of type {@link us.kbase.kbasefeaturevalues.ItemSetStat ItemSetStat}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public List<ItemSetStat> getMatrixRowSetsStat(GetMatrixSetsStatParams arg1) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(arg1);
        TypeReference<List<List<ItemSetStat>>> retType = new TypeReference<List<List<ItemSetStat>>>() {};
        List<List<ItemSetStat>> res = caller.jsonrpcCall("KBaseFeatureValues.get_matrix_row_sets_stat", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_matrix_column_sets_stat</p>
     * <pre>
     * </pre>
     * @param   arg1   instance of type {@link us.kbase.kbasefeaturevalues.GetMatrixSetsStatParams GetMatrixSetsStatParams}
     * @return   instance of list of type {@link us.kbase.kbasefeaturevalues.ItemSetStat ItemSetStat}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public List<ItemSetStat> getMatrixColumnSetsStat(GetMatrixSetsStatParams arg1) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(arg1);
        TypeReference<List<List<ItemSetStat>>> retType = new TypeReference<List<List<ItemSetStat>>>() {};
        List<List<ItemSetStat>> res = caller.jsonrpcCall("KBaseFeatureValues.get_matrix_column_sets_stat", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_matrix_stat</p>
     * <pre>
     * </pre>
     * @param   arg1   instance of type {@link us.kbase.kbasefeaturevalues.GetMatrixStatParams GetMatrixStatParams}
     * @return   instance of type {@link us.kbase.kbasefeaturevalues.MatrixStat MatrixStat}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public MatrixStat getMatrixStat(GetMatrixStatParams arg1) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(arg1);
        TypeReference<List<MatrixStat>> retType = new TypeReference<List<MatrixStat>>() {};
        List<MatrixStat> res = caller.jsonrpcCall("KBaseFeatureValues.get_matrix_stat", args, retType, true, true);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_submatrix_stat</p>
     * <pre>
     * </pre>
     * @param   arg1   instance of type {@link us.kbase.kbasefeaturevalues.GetSubmatrixStatParams GetSubmatrixStatParams}
     * @return   instance of type {@link us.kbase.kbasefeaturevalues.SubmatrixStat SubmatrixStat}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public SubmatrixStat getSubmatrixStat(GetSubmatrixStatParams arg1) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(arg1);
        TypeReference<List<SubmatrixStat>> retType = new TypeReference<List<SubmatrixStat>>() {};
        List<SubmatrixStat> res = caller.jsonrpcCall("KBaseFeatureValues.get_submatrix_stat", args, retType, true, true);
        return res.get(0);
    }
}
