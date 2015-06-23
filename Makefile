TARGET ?= /kb/deployment
DIR = $(shell pwd)
LOCAL_BIN = $(DIR)/bin
BIN = $(TARGET)/bin
SERVICE_NAME = KBaseFeatureValues
ASYNC_JOB_SCRIPT_NAME = run_KBaseFeatureValues_async_job.sh
SUB_SERVICE_NAME = ClusterService
SUB_ASYNC_JOB_SCRIPT_FILE = run_ClusterService_async_job.sh
ANT = ant
TESTCFG ?= test.cfg


all: compile

compile:
	mkdir -p $(LOCAL_BIN)
	echo '#!/bin/bash' > $(LOCAL_BIN)/$(SUB_ASYNC_JOB_SCRIPT_FILE)
	echo 'export KB_TOP=$(TARGET)' >> $(LOCAL_BIN)/$(SUB_ASYNC_JOB_SCRIPT_FILE)
	echo 'export KB_RUNTIME=/kb/runtime' >> $(LOCAL_BIN)/$(SUB_ASYNC_JOB_SCRIPT_FILE)
	echo 'export PATH=$$KB_RUNTIME/bin:$$KB_TOP/bin:$$PATH' >> $(LOCAL_BIN)/$(SUB_ASYNC_JOB_SCRIPT_FILE)
	echo 'export PYTHONPATH=$$KB_TOP/lib:$$PYTHONPATH' >> $(LOCAL_BIN)/$(SUB_ASYNC_JOB_SCRIPT_FILE)
	echo 'cd $(DIR)/clusterservice' >> $(LOCAL_BIN)/$(SUB_ASYNC_JOB_SCRIPT_FILE)
	echo 'python ClusterServiceServer.py $$1 $$2 $$3' >> $(LOCAL_BIN)/$(SUB_ASYNC_JOB_SCRIPT_FILE)
	chmod a+x $(LOCAL_BIN)/$(SUB_ASYNC_JOB_SCRIPT_FILE)
	$(ANT) compile

deploy: deploy-client deploy-service deploy-scripts

undeploy:
	@echo "Nothing to undeploy"

deploy-client:
	@echo "No deployment for client"

deploy-service:
	@echo "No deployment for service"

deploy-scripts:
	@echo "No deployment for scripts"

test: compile test-client test-service test-scripts

test-client:
	@echo "No tests for client"

test-service:
	@echo "No tests for service"

test-scripts:
	test/cfg_to_runner.py $(TESTCFG) "$(ANT_OPTIONS)"
	test/run_tests.sh

clean:
	@echo "No clean is necessary"
