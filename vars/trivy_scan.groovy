def call() {
    sh '''
        trivy fs . \
        --format table \
        --severity HIGH,CRITICAL
    '''
}
